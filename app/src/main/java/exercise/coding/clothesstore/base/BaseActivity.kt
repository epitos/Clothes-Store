package exercise.coding.clothesstore.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_product.*


abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun getLayoutResource(): Int

    protected abstract fun setViewReferences()

    protected abstract fun setupActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
        setViewReferences()
        setupActivity()
        setSupportActionBar(toolbar)
    }

    protected fun setToolbarTitle(titleId: Int) {
        toolbar.title = getString(titleId)
    }
}
