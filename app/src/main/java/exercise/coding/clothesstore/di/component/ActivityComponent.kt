package exercise.coding.clothesstore.di.component

import dagger.Component
import exercise.coding.clothesstore.di.module.ProductActivityModule
import exercise.coding.clothesstore.ui.product.activity.ProductActivity

@Component(modules = [ProductActivityModule::class])
interface ActivityComponent {

    fun inject(productActivity: ProductActivity)
}