package trees

import TreeNode
import java.util.*

fun <T> TreeNode<T>.printEachLevel() {
    val queue = ArrayDeque<TreeNode<T>>()
    var nodesLeftInEachLevel = 0
    // add root node
    queue.add(this)

    while (queue.isEmpty().not()) {
        nodesLeftInEachLevel = queue.count()
        while(nodesLeftInEachLevel > 0)
        {
            val node= queue.peek()
            node?.let {
                queue.removeFirst()
                print("${it.value} " )
                it.children.forEach { queue.add(it) }
            }?:break
            nodesLeftInEachLevel--
        }
        println()
    }
}