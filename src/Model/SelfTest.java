package Model;

public class SelfTest implements Runnable {
    private Error error;
    private InsulinPumpSystem insulinPumpRemoval;
    private insulinresrvoir systemActivation;

    public SelfTest() {
        this.error = new Error();
        this.insulinPumpRemoval = new InsulinPumpSystem();
        this.systemActivation = new insulinresrvoir();
    }

    public String handleError (){
        if(error.getMessage().length() > 0){
            return "Error of Type: " + error.getType() + ", " + error.getMessage();
        }
        return null;
    }

    public String getErrorType (){
        return error.getType();
    }

    public boolean checkInsulinPumpRemoval (){
        try {
            if (insulinPumpRemoval.isSystemOn()) {
                insulinPumpRemoval.mesuredoseamount();
            }
            return true;
        }catch (Exception ex){
            error.setPumpError(ex.getMessage());
            return false;
        }
    }

    public float getAmountInsulinInReservoir (){
        try {
            return systemActivation.getAmountofinsulin();
        }catch (Exception ex){
            error.setNeedleError(ex.getMessage());
            return 0;
        }
    }

    @Override
    public void run() {
            while (true) {
                try {
                    checkInsulinPumpRemoval();
                    getAmountInsulinInReservoir();
                    Thread.sleep(30000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                catch (Exception ex){
                    handleError();
                }
            }
    }

}
