package com.wesleyaldrich.animedxd;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.wesleyaldrich.animedxd.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Atur fragment default saat activity pertama kali dibuat
        if (savedInstanceState == null) {
            loadFragment(new HomeFragment());
        }

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home) {
                loadFragment(new HomeFragment());
                return true;
            } else if (itemId == R.id.list) {
                loadFragment(new ListFragment());
                return true;
            } else if (itemId == R.id.about) {
                loadFragment(new AboutFragment());
                return true;
            }
            return false;
        });
    }

    private void loadFragment(Fragment fragment) {
        // Mendapatkan FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Memulai transaksi fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Mengganti fragment di dalam container
        fragmentTransaction.replace(R.id.frame_layout, fragment);

        // Commit transaksi
        fragmentTransaction.commit();
    }
}