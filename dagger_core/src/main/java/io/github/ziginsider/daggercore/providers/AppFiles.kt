package io.github.ziginsider.daggercore.providers

import java.io.File
import java.io.InputStream
import java.io.OutputStream

interface AppFiles {

    val cacheDir: File

    val filesDir: File

    val externalCacheDir: File?

    fun openContentInputStream(uri: String): InputStream

    fun openContentOutputStream(uri: String): OutputStream

    fun getFileName(uri: String): String?

    fun openAsset(path: String): InputStream

    /**
     * Deletes the file or directory.
     * If this pathname indicates a directory, then the directory must be empty in order to be deleted.
     *
     * @param file- the [File] to be deleted.
     * @return true if the file or directory is successfully deleted, false otherwise.
     */
    fun deleteFile(file: File): Boolean
}
