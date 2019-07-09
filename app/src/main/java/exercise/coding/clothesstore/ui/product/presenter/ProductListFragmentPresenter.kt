package exercise.coding.clothesstore.ui.product.presenter

import exercise.coding.clothesstore.network.ApiServiceInterface
import exercise.coding.clothesstore.network.model.Cart
import exercise.coding.clothesstore.ui.product.view.ProductListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProductListFragmentPresenter(private val view: ProductListView): ProductListPresenter {

    private var compositeDisposable = CompositeDisposable()

    override fun addToCart(productId: Int) {
        compositeDisposable.add(
            ApiServiceInterface.create().addToCart(productId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse))
    }

    override fun clearUpResources() {
        compositeDisposable.clear()
    }

    private fun handleResponse(response: Cart) {
        if (response != null) {
            view.updateCart()
        }
    }
}