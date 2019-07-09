package exercise.coding.clothesstore.ui.product.presenter

import exercise.coding.clothesstore.base.BaseFragment
import exercise.coding.clothesstore.network.ApiServiceInterface
import exercise.coding.clothesstore.network.model.Product
import exercise.coding.clothesstore.ui.navigation.presenter.FragmentNavigationPresenter
import exercise.coding.clothesstore.ui.product.fragment.ProductListFragment
import exercise.coding.clothesstore.ui.product.view.ProductView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProductActivityPresenter(private val view: ProductView) : ProductPresenter, FragmentNavigationPresenter {

    private var compositeDisposable = CompositeDisposable()

    override fun getProducts() {
        compositeDisposable.add(
            ApiServiceInterface.create().getProducts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse))
    }

    override fun clearUpResources() {
        compositeDisposable.clear()
    }

    override fun addFragment(fragment: BaseFragment) {
    }

    private fun handleResponse(response: ArrayList<Product>) {
        if (response != null) {
            view.hideProgressbar()
            view.setProductList(ProductListFragment.newInstance(response))
        }
    }
}