package com.example.trackitall;



import static com.example.trackitall.R.drawable.ic_red_foreground;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TimerRecViewAdapter extends RecyclerView.Adapter<TimerRecViewAdapter.ViewHolder> {

    private ArrayList<Timer> timer = new ArrayList<>();

    private Context context ;
    private boolean timerIsRunning = false;
    private boolean taskCreated = false;

    public TimerRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewlayout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    //TODO Change to sqlite
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
    holder.textLabel.setText(timer.get(position).getLabel());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!taskCreated){
                    Intent intent = new Intent(context, NewTaskActivity.class);
                    context.startActivity(intent);
                }else{
                    if(!timerIsRunning){
                        holder.simpleChronometer.setBackgroundResource(timer.get(position).getColor());
                        holder.simpleChronometer.setVisibility(View.VISIBLE);
                        holder.textLabel.setVisibility(View.VISIBLE);
                        holder.simpleChronometer.start();
                        timerIsRunning = true;
                    }else{
                        holder.simpleChronometer.stop();
                        timerIsRunning = false;
                    }
                }
            }
        });
    }

    //TODO Change to sqlite
    @Override
    public int getItemCount() {
        return timer.size();
    }

    public void setTimer(ArrayList<Timer> timer) {
        this.timer = timer;
        notifyDataSetChanged();
    }

        public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardLayout;
        private ImageView addTimer, timerBackground;
        private TextView textLabel;
        private RelativeLayout cardView;
        private Chronometer simpleChronometer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            addTimer = itemView.findViewById(R.id.addTimer);
            textLabel = itemView.findViewById(R.id.textLabel);
            cardLayout = itemView.findViewById(R.id.cardLayout);
            simpleChronometer = itemView.findViewById(R.id.simpleChronometer);

        }
    }
}
