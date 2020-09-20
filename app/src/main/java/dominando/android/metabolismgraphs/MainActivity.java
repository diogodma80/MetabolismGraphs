package dominando.android.metabolismgraphs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import dominando.android.metabolismgraphs.entity.Graph;
import dominando.android.metabolismgraphs.entity.PhysicalActivityLevel;
import dominando.android.metabolismgraphs.entity.Sex;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioButton_female;
    private RadioButton radioButton_male;

    private EditText editText_age;
    private EditText editText_weight;
    private EditText editText_height;

    private Spinner spinner_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButton_female = (RadioButton) findViewById(R.id.radioButton_female);
        radioButton_male = (RadioButton) findViewById(R.id.radioButton_male);

        editText_age = (EditText) findViewById(R.id.editText_age);
        editText_weight = (EditText) findViewById(R.id.editText_weight);
        editText_height = (EditText) findViewById(R.id.editText_weight);

        spinner_activity = (Spinner) findViewById(R.id.spinner_activity);

        spinner_activity.setAdapter(new ArrayAdapter<PhysicalActivityLevel>(this, android.R.layout.simple_list_item_1, PhysicalActivityLevel.values()));
    }

    public void buttonCaloriesOnClick(View view) {
        try {
            Integer age = getAge();
            Double weight = getWeight();
            Integer height = getHeight();
            Sex sex;
            PhysicalActivityLevel level = (PhysicalActivityLevel) spinner_activity.getSelectedItem();

            if(radioButton_female.isChecked()) {
                sex = Sex.FEMALE;
            } else {
                sex = Sex.MALE;
            }

            Double metabolicLevel = getMetabolicLevel(age, weight, height, sex, level);

            Graph graph = new Graph();
            graph.setMetabolicLevel(metabolicLevel);

            Intent intent = new Intent(this, CaloriesActivity.class);
            intent.putExtra("graph", graph);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private Double getMetabolicLevel(Integer age, Double weight, Integer height, Sex sex, PhysicalActivityLevel level) {
        Double mbLevel;

        if(sex.equals(Sex.FEMALE)) {
            mbLevel = (655 + (9.6D * weight) + (1.8D * height) - (4.7D * age))
                    * level.getMultiplyingFactor();
        } else {
            mbLevel = (66 + (13.7D * weight) + (5D * height) - (6.8D * age))
                    * level.getMultiplyingFactor();
        }

        return mbLevel;
    }

    private Integer getHeight() throws Exception {
        if(editText_height.getText().toString().trim().isEmpty()){
            throw new Exception(getString(R.string.input_height));
        } else {
            try {
                Integer height = Integer.parseInt(editText_height.getText().toString().trim());
                return height;
            } catch (Exception e) {
                throw new Exception(getString(R.string.invalid_height));
            }
        }
    }

    private Double getWeight() throws Exception {
        if(editText_weight.getText().toString().trim().isEmpty()) {
            throw new Exception(getString(R.string.input_weight));
        } else {
            try {
              Double weight = Double.parseDouble(editText_weight.getText().toString().trim())  ;
              return weight;
            } catch (Exception e) {
                throw new Exception(getString(R.string.invalid_weight));
            }
        }
    }

    private Integer getAge() throws Exception {
        if(editText_age.getText().toString().trim().isEmpty()) {
            throw new Exception(getString(R.string.input_age));
        } else {
            try {
                Integer age = Integer.parseInt(editText_age.getText().toString().trim());
                return age;
            } catch (Exception e) {
                throw new Exception(getString(R.string.invalid_age));
            }
        }
    }


}