package dbconnection;

class ParentClass {
    public int value;

    public void setValue(int value) {
        try {
            this.value = value;
        } catch (Exception e) {
            System.out.println("Error setting value: " + e);
        }
    }
}

class ChildClass extends ParentClass {
    @Override
    public void setValue(int value) {
        try {
            super.setValue(value);
        } catch (Exception e) {
            System.out.println("Error setting value in child class: " + e);
        }
    }
}