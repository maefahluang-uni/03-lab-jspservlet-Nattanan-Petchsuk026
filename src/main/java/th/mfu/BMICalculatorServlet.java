package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        double weight = Double.parseDouble(request.getParameter("weight"));
        double height = Double.parseDouble(request.getParameter("height"));
        //TODO: calculate bmi
        double bmi = calculateBMI(weight, height);

        //TODO: determine the built from BMI
        String build = determineBuild(bmi);
      
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi", bmi);
        request.setAttribute("build", build);

        //TODO: forward to jsp
        request.getRequestDispatcher("/bmiResult.jsp").forward(request, response);
    }
        // Calculate BMI
        private double calculateBMI(double weight, double height) {
        // BMI formula: weight (kg) / (height (m) * height (m))
        return weight / (height * height);
    }

        // Determine build from BMI
         private String determineBuild(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else if (bmi < 35) {
            return "Obese";
        } else {
            return "Extremely Obese";
        }
    }
}



