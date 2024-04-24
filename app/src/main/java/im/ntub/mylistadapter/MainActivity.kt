package im.ntub.mylistadapter

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

data class Item(
    val photo: Int ,
    val name: String //名字
)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.listView)
        //val items = arrayListOf<String>("First", "Second", "hello world", "11111", "AAAA", "NTUB", "First", "Second", "hello world", "11111", "AAAA", "NTUB","First", "Second", "hello world", "11111", "AAAA", "NTUB")
        val items2d = arrayListOf(
            arrayOf("標題-1", "無意義內容-1"),
            arrayOf("標題-2", "無意義內容-2"),
            arrayOf("標題-3", "無意義內容-3"),
            arrayOf("標題-7", "無意-4"),
            arrayOf("標題-9", "無意義內容-100")
        )
        //val arrayAdapter = ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, items)
        val arrayAdapter = object: ArrayAdapter<Array<String>>(this,
            android.R.layout.simple_list_item_2,
            android.R.id.text1, items2d){
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                val text1 = view.findViewById<TextView>(android.R.id.text1)
                val text2 = view.findViewById<TextView>(android.R.id.text2)
                text1.text = items2d[position][0]
                text2.text = items2d[position][1]
                return view
            }
        }
        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { parent, view, position, id ->
            AlertDialog.Builder(this)
                .setTitle("你按了${items2d[position][0]}!!")
                .setMessage("你按了${items2d[position][1]}!!")
                .setPositiveButton("好"){ d, w->}
                    .show()
        }
    }
}