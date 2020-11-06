import trees.getHeight
import trees.printEachLevel
import utils.BinaryTreeNode

fun main(args:Array<String>) {
    val tree=makeBinaryTree()
    print(tree.getHeight(tree))
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

fun makeBinaryTree(): BinaryTreeNode<Int> {
    // Build the sample tree shown in the diagram
    // Root of the tree
    val tree = BinaryTreeNode(15)

    // Second level
    val one = BinaryTreeNode(1)
    tree.left=one

    val seventeen = BinaryTreeNode(17)
    tree.right=seventeen

    // Third level
    val one2 = BinaryTreeNode(1)
    val five = BinaryTreeNode(5)
    val zero = BinaryTreeNode(0)
    one.left=one2
    one.right=five
    seventeen.left=zero
    val eleven = BinaryTreeNode(11)
    zero.left=eleven

    val ten = BinaryTreeNode(10)
    eleven.left=ten
    return tree
}