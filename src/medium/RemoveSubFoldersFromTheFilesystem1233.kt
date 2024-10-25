package medium

object RemoveSubFoldersFromTheFilesystem {

    fun removeSubfolders(folder: Array<String>): List<String> {
        // SORT FOLDER PATHS
        folder.sort()

        val folders = mutableListOf<String>()
        folders.add(folder[0])

        for (i in 1 until folder.size) {
            if (folder[i].isSubFolder(folders[folders.size - 1]))
                continue
            else
                folders.add(folder[i])
        }
        return folders
    }

    private fun String.isSubFolder(folder: String): Boolean {
        if (this.length < folder.length) return false

        if (this.startsWith(folder).not()) return false

        return this.substring(folder.length, folder.length + 1).startsWith("/")
    }
}