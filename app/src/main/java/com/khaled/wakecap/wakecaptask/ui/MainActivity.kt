package com.khaled.wakecap.wakecaptask.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.khaled.wakecap.wakecaptask.R
import com.khaled.wakecap.wakecaptask.databinding.ActivityMainBinding
import com.khaled.wakecap.wakecaptask.di.Injectable
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var workersViewModel: WorkersViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        title = getString(R.string.title)

        workersViewModel =
                ViewModelProviders.of(this, viewModelFactory).get(WorkersViewModel::class.java)

        with(binding) {
            setLifecycleOwner(this@MainActivity)
            viewModel = workersViewModel
        }

        workersViewModel.rolesLiveData.observe(this, Observer { list ->
            initViewPager(list)
        })

        workersViewModel.errorLiveData.observe(this, Observer {
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        })

    }

    private fun initViewPager(roles: List<String>) {
        val workersPagerAdapter = WorkersPagerAdapter(supportFragmentManager, roles)
        with(binding) {
            viewPager.adapter = workersPagerAdapter
            tabLayout.setupWithViewPager(binding.viewPager)
        }
    }
}