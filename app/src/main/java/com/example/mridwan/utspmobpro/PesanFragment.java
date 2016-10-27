package com.example.mridwan.utspmobpro;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mridwan.utspmobpro.adapter.Product;
import com.example.mridwan.utspmobpro.adapter.ProductListAdapter;
import com.example.mridwan.utspmobpro.utils.SharedPreference;

import java.util.ArrayList;
import java.util.List;


public class PesanFragment extends AppCompatActivity implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    public static final String ARG_ITEM_ID = "product_list";

    ListView productListView;
    List<Product> products, favorite;
    ProductListAdapter productListAdapter;

    SharedPreference sharedPreference;

    public PesanFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_produk);
        setProducts();
        sharedPreference = new SharedPreference();
        productListAdapter = new ProductListAdapter(getApplicationContext(), products);

        productListView = (ListView) findViewById(R.id.list_product);
        productListView.setAdapter(productListAdapter);
        productListView.setOnItemClickListener(this);
        productListView.setOnItemLongClickListener(this);

        Button btSimpan = (Button) findViewById(R.id.simpan);
        assert btSimpan != null;
        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iPemesanan = new Intent(getApplicationContext(), KeranjangPesanan.class);
                startActivity(iPemesanan);
                finish();

            }
        });

    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Product product = (Product) parent.getItemAtPosition(position);
        String alamat = Integer.toString(position);

        Intent i = new Intent(PesanFragment.this, MartabakMonkey.class);
        i.putExtra("param", alamat);
        startActivity(i);

        Toast.makeText(getApplicationContext(), product.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View view, int position, long arg3) {
        ImageView button = (ImageView) view.findViewById(R.id.imgbtn_favorite);

        String tag = button.getTag().toString();
        if (tag.equalsIgnoreCase("grey")) {
            sharedPreference.addFavorite(getApplicationContext(), products.get(position));
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.add_favr),
                    Toast.LENGTH_SHORT).show();

            button.setTag("green");
            button.setImageResource(R.drawable.add);
        } else {
            sharedPreference.removeFavorite(getApplicationContext(), products.get(position));
            button.setTag("grey");
            button.setImageResource(R.drawable.addnon);
            Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.remove_favr),
                    Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    private void setProducts() {

        Product product1 = new Product(1, "Martabak Cococrunh",
                "Martabak dengan lapisan cococrunch yang gurih membuat lidah tidak bisa berenti", 40000);
        Product product2 = new Product(2, "Martabak Blueberry",
                "Martabak Blueberry dengan lapisan slay segar serta aroma yang alami membuat kita ketagihan",35000);
        Product product3 = new Product(3, "Martabak Keju",
                "Buat pecinta keju,wajib nyobain yang satu ini dengan keju yang meleleh membuat rasanya selalu terbayang", 55000);
        Product product4 = new Product(4, "Martabak Greentea",
                "Untuk yang suka alami kini hadir martabak greentea aromanya membuat ketenangan dari kehidupan UTS yang menerka.", 65000);
        Product product5 = new Product(5, "Martabak Special",
                "Yang special tentu berbeda dengan 4 varian rasa menjadi satu kenikmatan dan bisa kalian miliki saat ini juga segera order!", 70000);

        products = new ArrayList<Product>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

    }


}
