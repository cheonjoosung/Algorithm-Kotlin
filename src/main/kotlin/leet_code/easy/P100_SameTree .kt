package leet_code.easy

class P100_SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }
        if (p == null || q == null) {
            return false
        }
        if (p.`val` != q.`val`) {
            return false
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}

fun main() {
    val one = TreeNode(1)
    val two = TreeNode(1)

    one.left = two


    val one1 = TreeNode(1)
    val two1 = TreeNode(1)
    one1.right = two1

    P100_SameTree().isSameTree(one, one1)
}