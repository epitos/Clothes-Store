package exercise.coding.clothesstore.ui.product.activity

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.View
import exercise.coding.clothesstore.R
import exercise.coding.clothesstore.base.BaseActivity
import exercise.coding.clothesstore.base.BaseFragment
import exercise.coding.clothesstore.di.component.DaggerActivityComponent
import exercise.coding.clothesstore.di.module.ProductActivityModule
import exercise.coding.clothesstore.ui.product.presenter.ProductActivityPresenter
import exercise.coding.clothesstore.ui.product.view.ProductView
import kotlinx.android.synthetic.main.activity_product.*
import javax.inject.Inject

class ProductActivity : BaseActivity(), ProductView {

    @Inject
    lateinit var presenter: ProductActivityPresenter
    private var fm: FragmentManager = supportFragmentManager
    private lateinit var ft: FragmentTransaction

    override fun getLayoutResource(): Int {
        return R.layout.activity_product
    }

    override fun setViewReferences() {
    }

    override fun setupActivity() {
        setToolbarTitle(R.string.app_name)
        injectDependency()
        presenter.getProducts()
    }

    override fun hideProgressbar() {
        progressbar.visibility = View.GONE
    }

    override fun setProductList(fragment: BaseFragment) {
        fragment.attachPresenter(presenter)
        ft = fm.beginTransaction()
        ft.replace(R.id.container, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent
            .builder()
            .productActivityModule(ProductActivityModule(this))
            .build()
        activityComponent.inject(this)
    }
}
