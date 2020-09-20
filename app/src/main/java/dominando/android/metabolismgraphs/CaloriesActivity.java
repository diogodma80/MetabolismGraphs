package dominando.android.metabolismgraphs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;

import dominando.android.metabolismgraphs.entity.Graph;

public class CaloriesActivity extends AppCompatActivity implements Serializable {

    EditText editTextBreakfast;
    EditText editTextMorningSnack;
    EditText editTextLunch;
    EditText editTextAfternoonSnack;
    EditText editTextDinner;
    EditText editTextEveningSnack;

    Graph graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        editTextBreakfast = (EditText) findViewById(R.id.editText_breakfast);
        editTextMorningSnack = (EditText) findViewById(R.id.editText_morning_snack);
        editTextLunch = (EditText) findViewById(R.id.editText_lunch);
        editTextAfternoonSnack = (EditText) findViewById(R.id.editText_afternoon_snack);
        editTextDinner = (EditText) findViewById(R.id.editText_dinner);
        editTextEveningSnack = (EditText) findViewById(R.id.editText_evening_snack);

        graph = (Graph) getIntent().getSerializableExtra("graph");
    }

    public void buttonLaunchGraphsOnClick(View view) {
        try {
            Double breakfast = getCalories(editTextBreakfast, getString(R.string.breakfast));
            Double morningSnack = getCalories(editTextMorningSnack, getString(R.string.morning_snack));
            Double lunch = getCalories(editTextLunch, getString(R.string.lunch));
            Double afternoonSnack = getCalories(editTextAfternoonSnack, getString(R.string.afternoon_snack));
            Double dinner = getCalories(editTextDinner, getString(R.string.dinner));
            Double eveningSnack = getCalories(editTextEveningSnack, getString(R.string.evening_snack));

            graph.setBreakfast(breakfast);
            graph.setMorningSnack(morningSnack);
            graph.setLunch(lunch);
            graph.setAfternoonSnack(afternoonSnack);
            graph.setDinner(dinner);
            graph.setEveningSnack(eveningSnack);

            Intent intent = new Intent(this, GraphActivity.class);
            intent.putExtra("graph", graph);
            startActivity(intent);
        } catch (Exception e) {
            Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_LONG).show();
        }
    }

    private Double getCalories(EditText text, String meal) throws Exception {
        Double calories = 0D;

        if(!text.getText().toString().trim().isEmpty()) {
            try {
                calories = Double.parseDouble(text.getText().toString().trim());
            } catch (Exception e) {
                throw new Exception(getString(R.string.invalid_calory_input) + meal);
            }
        }

        return calories;
    }
}