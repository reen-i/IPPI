 package com.comxa.nasheen.divalavida;


 import android.os.Bundle;
 import android.support.v4.app.Fragment;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;

 import com.jjoe64.graphview.GraphView;
 import com.jjoe64.graphview.series.DataPoint;
 import com.jjoe64.graphview.series.LineGraphSeries;


 /**
 * A simple {@link Fragment} subclass.
 */
public class GenerateFragment extends Fragment {


    public GenerateFragment() {
        // Required empty public constructor
    }

     public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);

     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_college, container, false);

        GraphView graph = (GraphView) v.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);

        return v;
    }

}
