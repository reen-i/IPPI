package com.comxa.nasheen.divalavida;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link } interface
 * to handle interaction events.
 * Use the {@link HomeFragment} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters
    private int mParam1;
    private View v;

    TextView tvvaluefemale;
    private int sumFemale;
    //private ListView homepage;


//    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
//     * @param param1 Parameter 1.

     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
//    public static HomeFragment newInstance(int param1) {
//        HomeFragment fragment = new HomeFragment();
//        Bundle args = new Bundle();
//        args.putInt(ARG_PARAM1, param1);
//
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void connect(){

        HashMap postData = new HashMap();
        //postData.put("btnLogin", "Login");
        postData.put("mobile", "android");

        PostResponseAsyncTask task = new PostResponseAsyncTask(getContext(), postData, new AsyncResponse(){


            public void processFinish(String output) {
                Log.d("nashreen", "processFinish: " + output);
                String[] result = output.split(",");
                sumFemale = Integer.parseInt(result[0]);
                int sumMale = Integer.parseInt(result[1]);
                int sumKYP = Integer.parseInt(result[2]);
                int sumKYUEM = Integer.parseInt(result[3]);
                int sumKYNS = Integer.parseInt(result[4]);
                int tappNew = Integer.parseInt(result[5]);
                int tappInpro = Integer.parseInt(result[6]);
                int tappApp = Integer.parseInt(result[7]);
                int tappRej = Integer.parseInt(result[8]);

                GraphView graph = (GraphView) v.findViewById(R.id.graph1);
                BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                        new DataPoint(0, 0),
                        new DataPoint(1, tappNew),
                        new DataPoint(2, tappInpro),
                        new DataPoint(3, tappApp),
                        new DataPoint(4, tappRej),
                        new DataPoint(5, 0)
                        
                });
                graph.addSeries(series);
                series.setSpacing(50);
                series.setAnimated(true);
                series.setDrawValuesOnTop(true);
                series.setValuesOnTopColor(Color.DKGRAY);
                series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
                    @Override
                    public int get(DataPoint data) {
                        return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
                    }
                });
                series.setTitle("Baru");
                series.setTitle("Dalam Proses");

                StaticLabelsFormatter abc = new StaticLabelsFormatter(graph);
                abc.setHorizontalLabels(new String[] {"", "Baru", "Dalam Proses", "Diterima", "Ditolak", " "});
                //abc.setVerticalLabels(new String[] {"0", "10", "20", "30", "40", "50"});
                graph.getGridLabelRenderer().setLabelFormatter(abc);

                graph.getViewport().setXAxisBoundsManual(true);
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(6);
                graph.getViewport().setScrollable(true);

                graph.getLegendRenderer().setVisible(true);
                graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);

//                PieChart pctotal = (PieChart) v.findViewById(R.id.pctotal);
//
//                List<Entry> entries = new ArrayList<>();
//                    entries.add(new Entry(4f,0));
//                    entries.add(new Entry(8f,1));
//                    entries.add(new Entry(6f, 2));
//                    entries.add(new Entry(12f, 3));
//                    entries.add(new Entry(18f, 4));
//                    entries.add(new Entry(9f, 5));
//
//                PieDataSet dataSet = new PieDataSet(entries, "Months");
//
//                ArrayList<String> labels = new ArrayList<>();
//                labels.add("Jan");
//                labels.add("Feb");
//                labels.add("March");
//                labels.add("April");
//                labels.add("May");
//                labels.add("June");
//
//                PieData data = new PieData(labels, dataSet);
//                pctotal.setData(data);

                GraphView graph1 = (GraphView) v.findViewById(R.id.graph2);
                BarGraphSeries<DataPoint> series1 = new BarGraphSeries<>(new DataPoint[] {
                        new DataPoint(0, 0),
                        new DataPoint(1, sumFemale),
                        new DataPoint(2, sumMale),
                });
                graph1.addSeries(series1);

                graph1.addSeries(series1);
                series1.setSpacing(50);
                series1.setAnimated(true);
                series1.setDrawValuesOnTop(true);
                series1.setValuesOnTopColor(Color.DKGRAY);

                StaticLabelsFormatter def = new StaticLabelsFormatter(graph);
                def.setHorizontalLabels(new String[] {"", "Perempuan", "Lelaki"});
                graph1.getGridLabelRenderer().setLabelFormatter(def);

                GraphView graph2 = (GraphView) v.findViewById(R.id.graph3);
                BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(new DataPoint[] {
                        new DataPoint(0, 0),
                        new DataPoint(1, sumKYP),
                        new DataPoint(2, sumKYUEM),
                        new DataPoint(3, sumKYNS)

                });
                graph2.addSeries(series2);

                graph2.addSeries(series);
                series2.setSpacing(50);
                series2.setAnimated(true);
                series2.setDrawValuesOnTop(true);
                series2.setValuesOnTopColor(Color.DKGRAY);

                StaticLabelsFormatter ghi = new StaticLabelsFormatter(graph);
                ghi.setHorizontalLabels(new String[] {"", "KYP", "KYUEM", "KYNS"});
                graph2.getGridLabelRenderer().setLabelFormatter(ghi);


                GraphView graph3 = (GraphView) v.findViewById(R.id.graph4);
                BarGraphSeries<DataPoint> series3 = new BarGraphSeries<>(new DataPoint[] {
                        new DataPoint(0, 0),
                        new DataPoint(2, sumFemale),
                        new DataPoint(4, 6),
                        new DataPoint(6, 7),
                        new DataPoint(8, 5)
                });
                graph3.addSeries(series3);

                graph3.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
                    @Override
                    public String formatLabel(double value, boolean isValueX) {
                        if (isValueX) {
                            // show normal x values
                            return super.formatLabel(value, isValueX);
                        } else {
                            // show currency for y values
                            return super.formatLabel(value, isValueX);
                        }
                    }
                });

                GraphView graph4 = (GraphView) v.findViewById(R.id.graph5);
                BarGraphSeries<DataPoint> series4 = new BarGraphSeries<>(new DataPoint[] {
                        new DataPoint(0, 1),
                        new DataPoint(1, sumFemale),
                        new DataPoint(2, 7),
                        new DataPoint(3, 5),
                        new DataPoint(4, 0)
                });
                graph4.addSeries(series4);

            }
        }
        );
        task.execute("http://10.0.2.2/client/testhome.php");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        Integer total = mParam1 * 5;
//        onButtonPressed(total.toString());

        Log.d("", "onCreateView: masuk");

        v = inflater.inflate(R.layout.fragment_home, container, false);
        connect();
        //tvvaluefemale = (TextView) v.findViewById(R.id.valueFemale);

    return v;
    }
}

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(String data) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(data);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(String data);
//    }

