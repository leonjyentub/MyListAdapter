package im.ntub.mylistadapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

public class MyAdapter(context: Context,
                       private val data: ArrayList<Item>,
                       val layoutId: Int): ArrayAdapter<Item>(context, layoutId, data) {
    //回傳長度
    override fun getCount() = data.size
    //回傳指定位置的資料
    override fun getItem(position: Int) = data[position]
    //回傳指定位置的資料識別標籤
    override fun getItemId(position: Int) = 0L
    //回傳指定位置的Item畫面
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //按要自定的layout建立畫面
        val view = View.inflate(parent.context, layoutId, null)
        //依據position取得對應的內容
        val item = getItem(position)?: return view
        //拿不到東西就直接回傳這次的view
        //將資料指派給元件顯示
        val photo = view.findViewById<ImageView>(R.id.imgPhoto)
        val txtName = view.findViewById<TextView>(R.id.txtName)
        photo.setImageResource(item.photo)
        txtName.text = item.name
        return view
    }
}
