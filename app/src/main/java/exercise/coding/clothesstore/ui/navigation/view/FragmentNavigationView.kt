package exercise.coding.clothesstore.ui.navigation.view

import exercise.coding.clothesstore.ui.product.presenter.ProductActivityPresenter

interface FragmentNavigationView {
    fun attachPresenter(presenter: ProductActivityPresenter)
}