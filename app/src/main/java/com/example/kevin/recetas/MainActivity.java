package com.example.kevin.recetas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RecetasFragment.CallBack{

    private HomeFragment homeFragment;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        homeFragment = new HomeFragment();
        setFragment(homeFragment);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_id);
        navigationView = (NavigationView) findViewById(R.id.navigation_view_id);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.recetas:{
                        setFragment(new RecetasFragment());
                        break;
                    }
                    case R.id.about_us: {
                        setFragment(new AboutUsFragment());
                        break;
                    }
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }


    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentHomeContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @Override
    public void recibirRecetaDeFragment(Receta receta) {
        Intent intent = new Intent(this, DetalleActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetalleActivity.RECETA_KEY, receta);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
