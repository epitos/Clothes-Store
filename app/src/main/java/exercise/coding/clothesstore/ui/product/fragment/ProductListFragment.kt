package exercise.coding.clothesstore.ui.product.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.view.View
import exercise.coding.clothesstore.R
import exercise.coding.clothesstore.base.BaseFragment
import exercise.coding.clothesstore.di.component.DaggerActivityComponent
import exercise.coding.clothesstore.di.component.DaggerFragmentComponent
import exercise.coding.clothesstore.di.module.ProductActivityModule
import exercise.coding.clothesstore.di.module.ProductListFragmentModule
import exercise.coding.clothesstore.network.model.Product
import exercise.coding.clothesstore.ui.product.adapter.ProductListAdapter
import exercise.coding.clothesstore.ui.product.presenter.ProductActivityPresenter
import exercise.coding.clothesstore.ui.product.presenter.ProductListFragmentPresenter
import exercise.coding.clothesstore.ui.product.view.ProductListView
import kotlinx.android.synthetic.main.fragment_product_list.*
import javax.inject.Inject


private const val PRODUCT_LIST = "product_list"


class ProductListFragment : BaseFragment(), ProductListView {

    @Inject
    lateinit var presenter: ProductListFragmentPresenter
    private var productList: ArrayList<Product>? = null
    private var productListAdapter: ProductListAdapter? = null

    override fun setViewReferences(view: View) {}

    override fun setupActivity() {
        injectDependency()
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        product_list.layoutManager = layoutManager
        productListAdapter = productList?.let {
            activity?.let { ProductListAdapter(activity!!, productList!!) }
        }
        product_list.adapter = productListAdapter
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_product_list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            productList = it.getParcelableArrayList(PRODUCT_LIST)
        }
    }

    override fun updateCart() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun injectDependency() {
        val activityComponent = DaggerFragmentComponent
            .builder()
            .productListFragmentModule(ProductListFragmentModule(this))
            .build()
        activityComponent.inject(this)
    }

    companion object {
        @JvmStatic
        fun newInstance(productList: ArrayList<Product>) =
            ProductListFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(PRODUCT_LIST, productList)
                }
            }
    }
}
