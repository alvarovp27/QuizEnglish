package com.quizenglishb1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.quizenglishb1.com.quizenglishb1.utilities.Answer;

import java.util.List;

/**
 * Created by Alvaro on 07/08/2015.
 */
public class AnswerAdapter extends BaseAdapter{

    private Context context;
    private List<Answer> answers;

    public AnswerAdapter(Context context, List<Answer> answers){
        this.context=context;
        this.answers=answers;
    }

    @Override
    public int getCount() {
        return answers.size();
    }

    @Override
    public Object getItem(int position) {
        return answers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.activity_summary_list, parent, false);
        }

        ImageView isRight = (ImageView) rowView.findViewById(R.id.itemIsRight);
        TextView question = (TextView) rowView.findViewById(R.id.itemQuestion);
        TextView answered = (TextView) rowView.findViewById(R.id.itemAnswered);

        Answer answer = this.answers.get(position);
        question.setText(answer.getQuestion());
        answered.setText(answer.getRightAsnwers().toString());

        if(!answer.isRight())
            isRight.setImageResource(R.drawable.ic_wrong);
        else
            isRight.setImageResource(R.drawable.ic_right);

        return rowView;
    }
}
