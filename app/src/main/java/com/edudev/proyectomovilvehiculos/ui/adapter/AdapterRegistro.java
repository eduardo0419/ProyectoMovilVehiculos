package com.edudev.proyectomovilvehiculos.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.edudev.proyectomovilvehiculos.R;
import com.edudev.proyectomovilvehiculos.io.model.Registro;

import java.util.ArrayList;

/**
 * Created by pc on 07/01/2017.
 */

public class AdapterRegistro extends RecyclerView.Adapter<AdapterRegistro.RegistroViewHolder> {

    ArrayList<Registro> registros;
    Context contexts;

    public AdapterRegistro(ArrayList<Registro> registros, Context context) {
        this.registros = registros;
        this.contexts = context;
    }

    @Override
    public RegistroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.hoja_registro,parent,false);
        RegistroViewHolder registroViewHolder=new RegistroViewHolder(view);
        return registroViewHolder;
    }

    @Override
    public void onBindViewHolder(RegistroViewHolder holder, int position) {
        holder.label_codigo.setText(registros.get(position).getDoc());
        holder.label_marca.setText(registros.get(position).getMarca());
        holder.label_descripcion.setText(registros.get(position).getDescripcion()+" - PLACA:"+registros.get(position).getPlaca());
        holder.label_fecha.setText(registros.get(position).getFecha());
        holder.context=contexts;
    }

    @Override
    public int getItemCount() {
        return registros.size();
    }

    public static class RegistroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView label_codigo;
        TextView label_marca;
        TextView label_descripcion;
        TextView label_fecha;
        Button btn_editar;
        Context context;

        public RegistroViewHolder(View itemView) {
            super(itemView);

            label_codigo=(TextView)itemView.findViewById(R.id.label_codigo);
            label_marca=(TextView)itemView.findViewById(R.id.label_marca);
            label_descripcion=(TextView)itemView.findViewById(R.id.label_descripcion);
            label_fecha=(TextView)itemView.findViewById(R.id.label_fecha);
            btn_editar=(Button)itemView.findViewById(R.id.btn_editar);

            btn_editar.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId()==R.id.btn_editar){
                Toast.makeText(context,"Llama editar",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
