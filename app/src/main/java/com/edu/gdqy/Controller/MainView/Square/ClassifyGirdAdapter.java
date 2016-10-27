package com.edu.gdqy.Controller.MainView.Square;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.edu.gdqy.Controller.R;
import com.edu.gdqy.Tool.CircularTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HXY on 2016/10/9.
 * 广场里分类界面里面GridView的Adapter
 */

public class ClassifyGirdAdapter extends BaseAdapter {

    private List<String> texts;
    private LayoutInflater inflater;

    public ClassifyGirdAdapter(List<String> texts, Context context) {
        this.texts = texts;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return texts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_square_classify, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.ItemGridviewCircularView.setTextContent(texts.get(position));
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.Item_Classify_CircularView)
        CircularTextView ItemGridviewCircularView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
