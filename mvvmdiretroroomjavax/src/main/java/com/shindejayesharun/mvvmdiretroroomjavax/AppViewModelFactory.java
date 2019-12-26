package com.shindejayesharun.mvvmdiretroroomjavax;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.shindejayesharun.mvvmdiretroroomjavax.repository.Repository;
import com.shindejayesharun.mvvmdiretroroomjavax.ui.MainViewModel;

import javax.inject.Inject;

import dagger.Module;


public class AppViewModelFactory implements ViewModelProvider.Factory {
    /*@NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return null;
    }
*/
    @Inject
    Repository repository;


    @Inject
    public AppViewModelFactory() {
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(repository);
        }
        throw new IllegalArgumentException("Wrong ViewModel class");
    }
}
