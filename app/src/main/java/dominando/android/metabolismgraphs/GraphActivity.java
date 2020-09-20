package dominando.android.metabolismgraphs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import dominando.android.metabolismgraphs.entity.Graph;
import dominando.android.metabolismgraphs.entity.Meals;

public class GraphActivity extends AppCompatActivity {

    WebView webView;

    Graph graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        webView = (WebView) findViewById(R.id.web_view);
        webView.addJavascriptInterface(new WebAppInterface(), "android");
        webView.getSettings().setJavaScriptEnabled(true);

        graph = (Graph) getIntent().getSerializableExtra("graph");

        buttonBarOnClick(null);
        buttonPizzaOnClick(null);
    }

    public void buttonBarOnClick(View view) {
        webView.loadUrl("file:///android_asset/daily_calories_bar.html");
    }

    public void buttonPizzaOnClick(View view) {
        webView.loadUrl("file:///android_asset/daily_calories_pizza.html");
    }

    public class WebAppInterface {
        @JavascriptInterface
        public String getBarTitle() {
            return getString(R.string.bar_graph);
        }

        @JavascriptInterface
        public String getPizzaTitle() {
            return getString(R.string.pizza_graph);
        }

        @JavascriptInterface
        public String getMealTitle() {
            return getString(R.string.meal);
        }

        @JavascriptInterface
        public String getCaloriesTitle() {
            return getString(R.string.calories);
        }

        @JavascriptInterface
        public String getIntakeTitle() {
            return getString(R.string.intake);
        }

        @JavascriptInterface
        public String getRecommendedTitle() {
            return getString(R.string.recommended);
        }

        @JavascriptInterface
        public String getBreakfastTitle() {
            return getString(R.string.breakfast);
        }

        @JavascriptInterface
        public String getMorningSnackTitle() {
            return getString(R.string.morning_snack);
        }

        @JavascriptInterface
        public String getLunchTitle() {
            return getString(R.string.lunch);
        }

        @JavascriptInterface
        public String getAfternoonSnackTitle() {
            return getString(R.string.afternoon_snack);
        }

        @JavascriptInterface
        public String getDinnerTitle() {
            return getString(R.string.dinner);
        }

        @JavascriptInterface
        public String getEveningSnackTitle() {
            return getString(R.string.evening_snack);
        }

        @JavascriptInterface
        public double getIntakeBreakfast() {
            return graph.getBreakfast();
        }

        @JavascriptInterface
        public double getIntakeMorningSnack() {
            return graph.getMorningSnack();
        }

        @JavascriptInterface
        public double getIntakeLunch() {
            return graph.getLunch();
        }

        @JavascriptInterface
        public double getIntakeAfternoonSnack() {
            return graph.getAfternoonSnack();
        }

        @JavascriptInterface
        public double getIntakeDinner() {
            return graph.getDinner();
        }

        @JavascriptInterface
        public double getIntakeEveningSnack() {
            return graph.getEveningSnack();
        }

        @JavascriptInterface
        public double getRecommendedBreakfast() {
            return getRecommendedCalories(Meals.BREAKFAST);
        }

        @JavascriptInterface
        public double getRecommendedMorningSnack() {
            return getRecommendedCalories(Meals.MORNING_SNACK);
        }

        @JavascriptInterface
        public double getRecommendedLunch() {
            return getRecommendedCalories(Meals.LUNCH);
        }

        @JavascriptInterface
        public double getRecommendedAfternoonSnack() {
            return getRecommendedCalories(Meals.AFTERNOON_SNACK);
        }

        @JavascriptInterface
        public double getRecommendedDinner() {
            return getRecommendedCalories(Meals.DINNER);
        }

        @JavascriptInterface
        public double getRecommendedEveningSnack() {
            return getRecommendedCalories(Meals.EVENING_SNACK);
        }

        private double getRecommendedCalories(Meals meal) {
            return graph.getMetabolicLevel() * meal.getCaloriesPercentage() / 100D;
        }
    }
}