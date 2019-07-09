package exercise.coding.clothesstore.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import exercise.coding.clothesstore.ui.navigation.presenter.FragmentNavigationPresenter
import exercise.coding.clothesstore.ui.navigation.view.FragmentNavigationView
import exercise.coding.clothesstore.ui.product.presenter.ProductActivityPresenter

abstract class BaseFragment : Fragment(), FragmentNavigationView {

    private var navigationPresenter: FragmentNavigationPresenter? = null

    protected abstract fun getLayoutResource(): Int

    protected abstract fun setViewReferences(view: View)

    protected abstract fun setupActivity()

    override fun attachPresenter(presenter: ProductActivityPresenter) {
        navigationPresenter = presenter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayoutResource(), container, false)
        setViewReferences(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupActivity()
    }
}
