package com.company.service;

import com.company.model.IMCClassification;
import com.company.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public String calculateIMC (User user) {

        double weight =user.getWeight();
        double height =user.getWeight();

        double imc = weight / (height * height);

        IMCClassification result;
        // Clasificación según el valor del IMC
        if (imc <= 18.5) {
            result = IMCClassification.INFRAPESO;
        } else if (imc <= 25.0) {
            result = IMCClassification.NORMAL;
        } else if (imc <= 30.0) {
            result = IMCClassification.SOBREPESO;
        } else {
            result = IMCClassification.OBESO;
        }
        return "Tu clasificación IMC es: " + result;
    }

    public int sumOfDigits(int N) {
        int totalSum = 0;

        // Calcular la suma de los dígitos directamente en el bucle
        for (int i = 1; i <= N; i++) {
            int number = i;
            while (number > 0) {
                totalSum += number % 10; // Suma el dígito actual
                number /= 10;            // Elimina el dígito menos significativo
            }
        }

        return totalSum;
    }

    public List<Object> moveZeros(List<Object> array){


        List<Object> result = new ArrayList<>();
        int zeroCount = 0;

        // Recorrer el array y agregar los elementos diferentes de cero al resultado.
        for (Object item : array) {
            if (item instanceof Integer && (Integer) item == 0) {
                zeroCount++;
            } else {
                result.add(item);
            }
        }

        // Agregar los ceros al final.
        for (int i = 0; i < zeroCount; i++) {
            result.add(0);
        }

        return result;
    }


}