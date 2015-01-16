package com.txm.androtest;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fragment fragment = new SectionListFragment(); 
        
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().add(android.R.id.content, fragment).commit();
    }
    
    public class SectionListFragment extends ListFragment {
        
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            String[] data = getResources().getStringArray(R.array.sections);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
            setListAdapter(adapter);
        }
        
        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            super.onListItemClick(l, v, position, id);
            
            Fragment fragment = new DetailListFragment(position);
            
            FragmentManager manager = getFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(android.R.id.content, fragment);
            ft.addToBackStack("Section" + position);
            ft.commit();
        }
    };
    
    public class DetailListFragment extends ListFragment {
        
        private int mPosition = 0;
        
        public DetailListFragment(int position) {
            mPosition = position;
        }
        
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            
            int resId = R.array.section1;
            switch(mPosition) {
                case 0:
                    resId = R.array.section1;
                    break;
            }
            
            String[] data = getResources().getStringArray(resId);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
            setListAdapter(adapter);
        }
        
        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            super.onListItemClick(l, v, position, id);
            
            switch(mPosition) {
                case 0:
                    openSection1(position);
                    break;
                case 1:
                    openSection2(position);
                    break;
                case 2:
                    openSection3(position);
                    break;
                case 3:
                    openSection4(position);
                    break;
                case 4:
                    openSection5(position);
                    break;
                case 5:
                    openSection7(position);
                    break;
                case 6:
                    openSection8(position);
                    break;
                case 7:
                    openSection9(position);
                    break;
            }
        }

        private void openSection9(int position) {

        }

        private void openSection8(int position) {

        }

        private void openSection7(int position) {

        }

        private void openSection5(int position) {

        }

        private void openSection4(int position) {
 
        }

        private void openSection3(int position) {
    }

        private void openSection2(int position) {
      }

        private void openSection1(int position) {
 
        }
    }
}
