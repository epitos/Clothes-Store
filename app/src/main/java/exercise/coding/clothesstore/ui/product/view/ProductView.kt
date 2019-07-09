package exercise.coding.clothesstore.ui.product.view

import exercise.coding.clothesstore.base.BaseFragment

interface ProductView {
    fun setProductList(fragment: BaseFragment)
    fun hideProgressbar()
}