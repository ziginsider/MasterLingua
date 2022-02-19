package io.github.ziginsider.masterlingua.common

import android.content.ContentResolver
import android.content.Context
import android.content.res.AssetManager
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log
import io.github.ziginsider.daggercore.providers.AppFiles
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class AndroidAppFiles @Inject constructor(
    private val context: Context,
    private val contentResolver: ContentResolver,
    private val assetManager: AssetManager
) : AppFiles {

    override val cacheDir: File get() = context.cacheDir

    override val filesDir: File get() = context.filesDir

    override val externalCacheDir: File? get() = context.externalCacheDir

    override fun openContentInputStream(uri: String): InputStream {
        val androidUri = Uri.parse(uri)
        requireUriFromContentResolver(androidUri)
        return checkNotNull(contentResolver.openInputStream(androidUri)) {
            "Can't open content input stream from $androidUri"
        }
    }

    override fun openContentOutputStream(uri: String): OutputStream {
        val androidUri = Uri.parse(uri)
        requireUriFromContentResolver(androidUri)
        return checkNotNull(contentResolver.openOutputStream(androidUri)) {
            "Can't open content output stream from $androidUri"
        }
    }

    override fun openAsset(path: String): InputStream {
        return assetManager.open(path)
    }

    override fun getFileName(uri: String): String? {
        val androidUri = Uri.parse(uri)
        requireUriFromContentResolver(androidUri)
        val cursor = contentResolver.query(androidUri, null, null, null, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val displayNameColumnIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (displayNameColumnIndex == COLUMN_IS_NOT_EXIST_RESULT) {
                    return null
                }
                return it.getString(displayNameColumnIndex)
            }
        }
        return null
    }

    override fun deleteFile(file: File): Boolean {
        if (!file.exists()) {
            Log.d(TAG, "deleteFile: file: ${file.path} doesn't exists")
            return false
        }
        return try {
            file.delete()
        } catch (e: IOException) {
            Log.e(TAG, "$e")
            false
        }
    }

    private fun requireUriFromContentResolver(uri: Uri) {
        val scheme = uri.scheme ?: throw UnsupportedOperationException("Uri '$uri' doesn't contain scheme.")
        if (isValidContentUriScheme(scheme)) {
            throw UnsupportedOperationException("Uri '$uri' is not available locally.")
        }
    }

    private fun isValidContentUriScheme(scheme: String): Boolean {
        return ContentResolver.SCHEME_ANDROID_RESOURCE != scheme &&
                ContentResolver.SCHEME_CONTENT != scheme &&
                ContentResolver.SCHEME_FILE != scheme
    }

    private companion object {

        private const val TAG = "AndroidAppFiles"
        private const val COLUMN_IS_NOT_EXIST_RESULT = -1
    }
}
