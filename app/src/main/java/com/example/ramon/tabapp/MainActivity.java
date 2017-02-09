package com.example.ramon.tabapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public void iniciaSpinner(){

    }

    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        private Spinner spinner;
        private EditText endereco;
        private EditText detalhesDaOcorrencia;
        private Button enviar;
        private Button anexar_foto;

        private Denuncia denuncia;

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                View rootView = inflater.inflate(R.layout.fragment_pagina_inicio, container, false);

                spinner = (Spinner) rootView.findViewById(R.id.spinner_denuncia);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                        R.array.selecao_ocorrencia,
                        android.R.layout.simple_spinner_item);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                endereco = (EditText) rootView.findViewById(R.id.endereco);
                detalhesDaOcorrencia = (EditText) rootView.findViewById(R.id.detalhes);

                enviar = (Button) rootView.findViewById(R.id.id_enviar);

                anexar_foto = (Button) rootView.findViewById(R.id.id_foto);

                enviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatabaseReference db;
                        FirebaseHelper helper;

                        db = FirebaseDatabase.getInstance().getReference();
                        helper = new FirebaseHelper(db);

                        denuncia = new Denuncia();

                        denuncia.setEndereço(endereco.getText().toString());
                        denuncia.setDetalhesDaOcorrencia(detalhesDaOcorrencia.getText().toString());
                        denuncia.setTipoDeOcorrencia(spinner.getSelectedItem().toString());

                        helper.Save(denuncia);

                        endereco.setText("");
                        detalhesDaOcorrencia.setText("");
                    }
                });

                anexar_foto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        File file = getFile();

                        camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                        startActivityForResult(camera_intent, 1);
                    }
                });

                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                View rootView = inflater.inflate(R.layout.fragment_pagina_lei, container, false);
                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
                View rootView = inflater.inflate(R.layout.fragment_pagina_contatos, container, false);
                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 4) {
                View rootView = inflater.inflate(R.layout.fragment_pagina_sobre, container, false);
                return rootView;
            } else{
                View rootView = inflater.inflate(R.layout.fragment_main, container, false);
                /*TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                textView.setText("Deu ruim");*/
                return rootView;
            }
        }

        private File getFile(){
            File folder = new File("sdcard/appPol");

            if(!folder.exists()){
                folder.mkdir();
            }

            File imagem = new File(folder, "imagem.jpg");

            return imagem;
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            String path = "sdcard/appPol/imagem.jpg";
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Início";
                case 1:
                    return "Lei Nº 123";
                case 2:
                    return "Contatos";
                case 3:
                    return "Sobre";
            }
            return null;
        }
    }
}
