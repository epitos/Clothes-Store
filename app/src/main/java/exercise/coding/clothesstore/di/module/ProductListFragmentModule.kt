package exercise.coding.clothesstore.di.module

import dagger.Module
import dagger.Provides
import exercise.coding.clothesstore.ui.product.presenter.ProductListFragmentPresenter
import exercise.coding.clothesstore.ui.product.view.ProductListView

@Module
class ProductListFragmentModule(private val view: ProductListView) {

    @Provides
    fun providePresenter(): ProductListFragmentPresenter {
        return ProductListFragmentPresenter(view)
    }
}