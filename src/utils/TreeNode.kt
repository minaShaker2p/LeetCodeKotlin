class TreeNode<T>(val value: T) {
  val children: MutableList<TreeNode<T>> = mutableListOf()

  fun add(child: TreeNode<T>) = children.add(child)
}