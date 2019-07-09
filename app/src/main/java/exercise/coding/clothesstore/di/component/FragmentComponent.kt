package exercise.coding.clothesstore.di.component

import dagger.Component
import exercise.coding.clothesstore.di.module.ProductListFragmentModule
import exercise.coding.clothesstore.ui.product.fragment.ProductListFragment

@Component(modules = [ProductListFragmentModule::class])

interface FragmentComponent {

    fun inject(fragment: ProductListFragment)
}