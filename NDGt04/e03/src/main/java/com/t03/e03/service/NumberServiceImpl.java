package com.t03.e03.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl implements NumberService{
        private List<Integer> numbers = new ArrayList<>();

        public List<Integer> getNumbers() {
            return numbers;
        }


        @Override
        public void addNumber() {
            Random random = new Random();
            numbers.add(random.nextInt(100) + 1);  
        }

        @Override
        public void deleteNumber(int index) {
            if (index >= 0 && index < numbers.size()) {
                numbers.remove(index);
            }
        }

}
