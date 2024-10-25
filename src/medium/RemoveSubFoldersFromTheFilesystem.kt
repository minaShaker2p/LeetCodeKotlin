package medium

object RemoveSubFoldersFromTheFilesystem {

    fun removeSubfolders(folder: Array<String>): List<String> {
        val subfolders = mutableSetOf<String>()
        for (i in folder.indices) {
            for (j in folder.indices) {
               if(i !=j && folder[i]!=folder[j] && folder[i].startsWith(folder[j])&& folder[i].length<folder[j].length)
               {
                   subfolders.add(folder[i])
               }

            }
        }
        return subfolders.toList()
    }
}