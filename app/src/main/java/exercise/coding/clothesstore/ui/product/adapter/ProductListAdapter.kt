package exercise.coding.clothesstore.ui.product.adapter

import android.app.Dialog
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import exercise.coding.clothesstore.R
import exercise.coding.clothesstore.network.model.Product
import exercise.coding.clothesstore.ui.product.presenter.ProductListFragmentPresenter
import kotlinx.android.synthetic.main.item_product.view.*


class ProductListAdapter(private val context: Context, private val presenter: ProductListFragmentPresenter, private val productList: ArrayList<Product>) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private var currentPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = productList.count()

    override fun onBindViewHolder(viewholder: ViewHolder, postion: Int) {
        viewholder.bind(productList[postion])
        viewholder.productCardView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                when(view?.id) {
                    R.id.productview -> showDialog()
                    R.id.add_to_cart -> presenter.addToCart(productList[viewholder.adapterPosition].productId)
                }
            }
        })
    }

    private fun showDialog() {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.product_menu_layout)
        val addToCart = dialog.findViewById(R.id.add_to_cart) as TextView
        val wishList = dialog.findViewById(R.id.wishlist) as TextView
        dialog.show()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var productNameTextView = view.product_title
        private var productPriceTextView = view.product_price
        private var productCategoryTextView = view.category
        private var productAvailabilityTextView = view.availability
        var productCardView = view.productview

        fun bind(product: Product) {
            productNameTextView.text = product.name
            productPriceTextView.text = "£" + product.price.toString()
            productCategoryTextView.text = product.category

            if (product.stock > 0) {
                productAvailabilityTextView.text = "Available"
            } else {
                productAvailabilityTextView.text = "Out of Stock"
            }

        }
    }
}