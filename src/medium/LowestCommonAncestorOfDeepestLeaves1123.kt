package medium

object LowestCommonAncestorOfDeepestLeaves1123 {
    fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
        return dfs(root).first
    }

    private fun dfs(root: TreeNode?): Pair<TreeNode?,Int>{
        if(root == null)
        {
            return Pair(null,0)
        }

        val left = dfs(root.left)
        val right = dfs(root.right)

        if(left.second> right.second)
        {
            return  Pair(left.first,left.second+1)
        }
        if(left.second < right.second){
            return Pair(right.first,right.second+1)
        }
        return Pair(root,left.second+1)
    }
}