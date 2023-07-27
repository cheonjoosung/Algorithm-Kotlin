package leet_code.easy

class P94_BinaryTreeInorderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return mutableListOf()
        else {
            val answer = mutableListOf<Int>()

            inorder(root, answer)


            return answer
        }
    }

    private fun inorder(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) return

        inorder(root.left, list)
        list.add(root.`val`)
        inorder(root.right, list)
    }
}

fun main() {
    val one = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)
    one.right = two
    two.left = three

    P94_BinaryTreeInorderTraversal().inorderTraversal(one)
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}