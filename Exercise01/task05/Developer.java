public class Developer {
    // Private attributes (5 attributes as required)
    private String name;
    private int age;
    private String email;
    private String programmingLanguage;
    private int yearsOfExperience;
    
    // Constructor
    public Developer(String name, int age, String email) {
        setName(name);
        setAge(age);
        setEmail(email);
        this.programmingLanguage = "Java"; // Default value
        this.yearsOfExperience = 0; // Default value
    }
    
    // Getter and Setter methods with integrity checks
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name.trim();
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        if (age < 16 || age > 100) {
            throw new IllegalArgumentException("Age must be between 16 and 100");
        }
        this.age = age;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Email must be valid format (contain @ and .)");
        }
        this.email = email.toLowerCase().trim();
    }
    
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
    
    public void setProgrammingLanguage(String programmingLanguage) {
        if (programmingLanguage == null || programmingLanguage.trim().isEmpty()) {
            throw new IllegalArgumentException("Programming language cannot be null or empty");
        }
        this.programmingLanguage = programmingLanguage.trim();
    }
    
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0 || yearsOfExperience > 50) {
            throw new IllegalArgumentException("Years of experience must be between 0 and 50");
        }
        this.yearsOfExperience = yearsOfExperience;
    }
    
    // Business methods (5 methods as required)
    public void writeCode() {
        System.out.println(name + " is writing code in " + programmingLanguage);
    }
    
    public void debugCode() {
        System.out.println(name + " is debugging code");
    }
    
    public void reviewCode() {
        System.out.println(name + " is reviewing code from colleagues");
    }
    
    public void learnNewTechnology() {
        System.out.println(name + " is learning new technology");
    }
    
    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", programmingLanguage='" + programmingLanguage + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }
    
    // Main method for testing
    public static void main(String[] args) {
        try {
            // Create developer object (like the object diagram)
            Developer myself = new Developer("John Student", 22, "john.student@university.edu");
            myself.setProgrammingLanguage("Java");
            myself.setYearsOfExperience(2);
            
            // Test the methods
            System.out.println("Developer created: " + myself);
            myself.writeCode();
            myself.debugCode();
            myself.reviewCode();
            myself.learnNewTechnology();
            
            // Test integrity checks
            System.out.println("\nTesting integrity checks:");
            try {
                myself.setAge(150); // Should throw exception
            } catch (IllegalArgumentException e) {
                System.out.println("Age validation works: " + e.getMessage());
            }
            
            try {
                myself.setEmail("invalid-email"); // Should throw exception
            } catch (IllegalArgumentException e) {
                System.out.println("Email validation works: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}