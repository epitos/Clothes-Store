package exercise.coding.clothesstore.di.module

import dagger.Module
import dagger.Provides
import exercise.coding.clothesstore.ui.product.presenter.ProductActivityPresenter
import exercise.coding.clothesstore.ui.product.view.ProductView

@Module
class ProductActivityModule(private val view: ProductView) {

    @Provides
    fun providePresenter(): ProductActivityPresenter {
        return ProductActivityPresenter(view)
    }
}