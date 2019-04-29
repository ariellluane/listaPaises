package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.listadepaises.R;

import java.util.List;

import Model.Paises;

public class Adapter extends ArrayAdapter<Paises> {
    public Adapter(Context context, List<Paises> objects) {
        super(context, 0, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Paises paises = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_paises, parent, false);
        }
        TextView tvname = (TextView) convertView.findViewById(R.id.name);
        TextView tvlat = (TextView) convertView.findViewById(R.id.latitude);
        TextView tvlong = (TextView) convertView.findViewById(R.id.longitude);
        TextView tvalphacode1 = (TextView) convertView.findViewById(R.id.alpha2Code);
        TextView tvalphacode2 = (TextView) convertView.findViewById(R.id.alpha3Code);
        TextView tvcapital = (TextView) convertView.findViewById(R.id.capital);
        TextView tvregion = (TextView) convertView.findViewById(R.id.region);
        TextView tvsubregion = (TextView) convertView.findViewById(R.id.subregion);
        TextView tvpopulation = (TextView) convertView.findViewById(R.id.population);
        TextView tvdemonym = (TextView) convertView.findViewById(R.id.demonym);
        TextView tvarea = (TextView) convertView.findViewById(R.id.area);
        TextView tvgini = (TextView) convertView.findViewById(R.id.gini);
        TextView tvnativename = (TextView) convertView.findViewById(R.id.nativename);
        TextView tvnumericcode = (TextView) convertView.findViewById(R.id.numericcode);

        tvname.setText(paises.name);
        tvlat.setText(paises.latitude);
        tvlong.setText(paises.longitude);
        tvalphacode1.setText(paises.alpha2Code);
        tvalphacode2.setText(paises.alpha3Code);
        tvcapital.setText(paises.capital);
        tvregion.setText(paises.region);
        tvsubregion.setText(paises.subregion);
        tvpopulation.setText(paises.population);
        tvdemonym.setText(paises.demonym);
        tvarea.setText(paises.area);
        tvgini.setText(paises.gini);
        tvnativename.setText(paises.nativename);
        tvnumericcode.setText(paises.numericCode);
        return convertView;

    }
}