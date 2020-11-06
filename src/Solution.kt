import trees.printEachLevel

fun main(args:Array<String>) {
    val tree=makeTree()
    tree.printEachLevel()
}


fun makeTree(): TreeNode<Int> {
    // Build the sample tree shown in the diagram
    // Root of the tree
    val tree = TreeNode(15)

    // Second level
    val one = TreeNode(1)
    tree.add(one)

    val seventeen = TreeNode(17)
    tree.add(seventeen)

    val twenty = TreeNode(20)
    tree.add(twenty)

    // Third level
    val one2 = TreeNode(1)
    val five = TreeNode(5)
    val zero = TreeNode(0)
    one.add(one2)
    one.add(five)
    one.add(zero)

    val two = TreeNode(2)
    seventeen.add(two)

    val five2 = TreeNode(5)
    val seven = TreeNode(7)
    twenty.add(five2)
    twenty.add(seven)

    return tree
}