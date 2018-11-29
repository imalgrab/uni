using System;
using System.Windows.Forms;

// kalkulator Igor Malgrab

namespace Calculator
{
    public partial class CalculatorMain : Form
    {
        Double finalValue = 0;
        Double resultValue = 0;
        String calcOperator = "";
        bool isCalcOperatorActive = false;

        public CalculatorMain()
        {
            InitializeComponent();
        }

        private void btnArg_Click(object sender, EventArgs e)
        {
            if (textBoxRes.Text.Equals("0") || isCalcOperatorActive)
            {
                textBoxRes.Clear();
            }

            Button button = (Button)sender;
            isCalcOperatorActive = false;
            labelCurrentExpr.Text += button.Text;

            if (!(button.Text.Equals(",") && textBoxRes.Text.Contains(",")))
            {
                textBoxRes.Text = textBoxRes.Text + button.Text;
            }
        }

        private void btnVar_Click(object sender, EventArgs e)
        {
            if (textBoxRes.Text.Equals("0") || isCalcOperatorActive)
            {
                textBoxRes.Clear();
            }

            Button button = (Button)sender;
            Variable variable = new Variable(button.Text);
            isCalcOperatorActive = false;
            labelCurrentExpr.Text += variable.Result();
            textBoxRes.Text += variable.Result();
        }


        private void btnPi_Click(object sender, EventArgs e)
        {
            if (textBoxRes.Text.Equals("0") || isCalcOperatorActive)
            {
                textBoxRes.Clear();
            }
            Button button = (Button)sender;
            Pi pi = new Pi();
            textBoxRes.Text = textBoxRes.Text + pi.Evaluate().ToString();
            isCalcOperatorActive = false;
        }

        private void btnE_Click(object sender, EventArgs e)
        {
            if (textBoxRes.Text.Equals("0") || isCalcOperatorActive)
            {
                textBoxRes.Clear();
            }
            Button button = (Button)sender;
            E ee = new E();
            textBoxRes.Text = textBoxRes.Text + ee.Evaluate().ToString();
            isCalcOperatorActive = false;
        }

        private void btnFi_Click(object sender, EventArgs e)
        {
            if (textBoxRes.Text.Equals("0") || isCalcOperatorActive)
            {
                textBoxRes.Clear();
            }
            Button button = (Button)sender;
            Fi fi = new Fi();
            textBoxRes.Text = textBoxRes.Text + fi.Evaluate().ToString();
            isCalcOperatorActive = false;
        }

        // unaryOps

        private void btnSqrtOp_Click(object sender, EventArgs e)
        {
            calcOperator = "sqrt";
            isCalcOperatorActive = true;

            if(resultValue != 0)
            {
                btnEq.PerformClick();
                resultValue = Double.Parse(textBoxRes.Text);
            }
            else
            {
                if (textBoxRes.Text.Equals("x") || textBoxRes.Text.Equals("y") || textBoxRes.Text.Equals("z"))
                {
                    using (var form = new CalculatorValueForVariables())
                    {
                        var result = form.ShowDialog();
                        if (result == DialogResult.OK)
                        {
                            resultValue = form.varValue;
                        }
                    }
                }
                else
                {
                    resultValue = Double.Parse(textBoxRes.Text);
                }

                labelCurrentExpr.Text = calcOperator + "(" + resultValue + ")";
            }
        }

        private void btnOpposite_Click(object sender, EventArgs e)
        {
            calcOperator = "neg";
            isCalcOperatorActive = true;
            
            if (resultValue != 0)
            {
                btnEq.PerformClick();
                resultValue = Double.Parse(textBoxRes.Text);
            }
            else 
            {
                if (textBoxRes.Text.Equals("x") || textBoxRes.Text.Equals("y") || textBoxRes.Text.Equals("z"))
                {
                    using (var form = new CalculatorValueForVariables())
                    {
                        var result = form.ShowDialog();
                        if (result == DialogResult.OK)
                        {
                            resultValue = form.varValue;
                        }
                    }
                }
                else
                {
                    resultValue = Double.Parse(textBoxRes.Text);
                }

                labelCurrentExpr.Text = calcOperator + "(" + resultValue + ")";
            }
        }

        private void btnCos_Click(object sender, EventArgs e)
        {
            calcOperator = "cos";
            isCalcOperatorActive = true;

            if (resultValue != 0)
            {
                btnEq.PerformClick();
                resultValue = Double.Parse(textBoxRes.Text);
            }
            else
            {
                if (textBoxRes.Text.Equals("x") || textBoxRes.Text.Equals("y") || textBoxRes.Text.Equals("z"))
                {
                    using (var form = new CalculatorValueForVariables())
                    {
                        var result = form.ShowDialog();
                        if (result == DialogResult.OK)
                        {
                            resultValue = form.varValue;
                        }
                    }
                }
                else
                {
                    resultValue = Double.Parse(textBoxRes.Text);
                }

                labelCurrentExpr.Text = calcOperator + "(" + resultValue + ")";
            }
        }

        private void btnSin_Click(object sender, EventArgs e)
        {
            calcOperator = "sin";
            isCalcOperatorActive = true;

            if (resultValue != 0)
            {
                btnEq.PerformClick();
                resultValue = Double.Parse(textBoxRes.Text);
            }
            else
            {
                if (textBoxRes.Text.Equals("x") || textBoxRes.Text.Equals("y") || textBoxRes.Text.Equals("z"))
                {
                    using (var form = new CalculatorValueForVariables())
                    {
                        var result = form.ShowDialog();
                        if (result == DialogResult.OK)
                        {
                            resultValue = form.varValue;
                        }
                    }
                }
                else
                {
                    resultValue = Double.Parse(textBoxRes.Text);
                }

                labelCurrentExpr.Text = calcOperator + "(" + textBoxRes.Text + ")";
            }
        }

        private void btnExp_Click(object sender, EventArgs e)
        {
            calcOperator = "exp";
            isCalcOperatorActive = true;

            if (resultValue != 0)
            {
                btnEq.PerformClick();
                resultValue = Double.Parse(textBoxRes.Text);
            }
            else
            {

                if (textBoxRes.Text.Equals("x") || textBoxRes.Text.Equals("y") || textBoxRes.Text.Equals("z"))
                {
                    using (var form = new CalculatorValueForVariables())
                    {
                        var result = form.ShowDialog();
                        if (result == DialogResult.OK)
                        {
                            resultValue = form.varValue;
                        }
                    }
                }
                else
                {
                    resultValue = Double.Parse(textBoxRes.Text);
                }

                labelCurrentExpr.Text = calcOperator + "(" + resultValue + ")";
            }
        }

        private void btnAbs_Click(object sender, EventArgs e)
        {
            calcOperator = "abs";
            isCalcOperatorActive = true;

            if (resultValue != 0)
            {
                btnEq.PerformClick();
                resultValue = Double.Parse(textBoxRes.Text);
            }
            else
            {

                if (textBoxRes.Text.Equals("x") || textBoxRes.Text.Equals("y") || textBoxRes.Text.Equals("z"))
                {
                    using (var form = new CalculatorValueForVariables())
                    {
                        var result = form.ShowDialog();
                        if (result == DialogResult.OK)
                        {
                            resultValue = form.varValue;
                        }
                    }
                }
                else
                {
                    resultValue = Double.Parse(textBoxRes.Text);
                }

                labelCurrentExpr.Text = calcOperator + "(" + resultValue + ")";
            }
        }

        private void btnLog_Click(object sender, EventArgs e)
        {
            calcOperator = "log";
            isCalcOperatorActive = true;

            if (resultValue != 0)
            {
                btnEq.PerformClick();
                resultValue = Double.Parse(textBoxRes.Text);
            }
            else
            {

                if (textBoxRes.Text.Equals("x") || textBoxRes.Text.Equals("y") || textBoxRes.Text.Equals("z"))
                {
                    using (var form = new CalculatorValueForVariables())
                    {
                        var result = form.ShowDialog();
                        if (result == DialogResult.OK)
                        {
                            resultValue = form.varValue;
                        }
                    }
                }
                else
                {
                    resultValue = Double.Parse(textBoxRes.Text);
                }

                labelCurrentExpr.Text = calcOperator + "(" + resultValue + ")";
            }
        }

        // binaryOps

        private void btnPowOp_Click(object sender, EventArgs e)
        {
            calcOperator = "^";
            isCalcOperatorActive = true;

            if (resultValue != 0)
            {
                btnEq.PerformClick();
                resultValue = Double.Parse(textBoxRes.Text);
                labelCurrentExpr.Text = textBoxRes.Text + " " + calcOperator + " ";
            }
            else
            {
                if (textBoxRes.Text.Equals("x") || textBoxRes.Text.Equals("y") || textBoxRes.Text.Equals("z"))
                {
                    using (var form = new CalculatorValueForVariables())
                    {
                        var result = form.ShowDialog();
                        if (result == DialogResult.OK)
                        {
                            resultValue = form.varValue;
                        }
                    }
                }
                else
                {
                    resultValue = Double.Parse(textBoxRes.Text);                    
                }

                labelCurrentExpr.Text = textBoxRes.Text + " " + calcOperator + " ";
            }            
        }

        private void btnMod_Click(object sender, EventArgs e)
        {
            calcOperator = "%";
            isCalcOperatorActive = true;

            if (resultValue != 0)
            {
                btnEq.PerformClick();
                resultValue = Double.Parse(textBoxRes.Text);
                labelCurrentExpr.Text = resultValue + " " + calcOperator + " ";
            }
            else
            {
                if (textBoxRes.Text.Equals("x") || textBoxRes.Text.Equals("y") || textBoxRes.Text.Equals("z"))
                {
                    using (var form = new CalculatorValueForVariables())
                    {
                        var result = form.ShowDialog();
                        if (result == DialogResult.OK)
                        {
                            resultValue = form.varValue;
                        }
                    }
                }
                else
                {
                    resultValue = Double.Parse(textBoxRes.Text);
                }

                labelCurrentExpr.Text = textBoxRes.Text + " " + calcOperator + " ";
            }
        }

        private void btnClassicOp_Click(object sender, EventArgs e)
        {
            Button button = (Button)sender;
            calcOperator = button.Text;
            isCalcOperatorActive = true;

            if (resultValue != 0)
            {
                btnEq.PerformClick();
                labelCurrentExpr.Text = resultValue + " " + calcOperator + " ";
            }
            else
            {
                if (textBoxRes.Text.Equals("x") || textBoxRes.Text.Equals("y") || textBoxRes.Text.Equals("z"))
                {
                    using (var form = new CalculatorValueForVariables())
                    {
                        var result = form.ShowDialog();
                        if (result == DialogResult.OK)
                        {
                            resultValue = form.varValue;
                        }
                    }
                    labelCurrentExpr.Text = textBoxRes.Text + " " + calcOperator + " ";
                }
                else
                {
                    resultValue = Double.Parse(textBoxRes.Text);
                    labelCurrentExpr.Text = resultValue + " " + calcOperator + " ";

                }
            }
        }

        // utilities

        private void btnCE_Click(object sender, EventArgs e)
        {
            textBoxRes.Text = "0";            
        }

        private void btnC_Click(object sender, EventArgs e)
        {
            textBoxRes.Text = "0";
            resultValue = 0;
            labelCurrentExpr.Text = "";
        }

        // evaluator
  
        private void btnEq_Click(object sender, EventArgs e)
        {
            Expression expression;
            Double sndArgument = new Double();


            if (textBoxRes.Text.Equals("x") || textBoxRes.Text.Equals("y") || textBoxRes.Text.Equals("z"))
            {
                using (var form = new CalculatorValueForVariables())
                {
                    var result = form.ShowDialog();
                    if (result == DialogResult.OK)
                    {
                        sndArgument = form.varValue;
                    }
                }
            }
            else
            {
                sndArgument = Double.Parse(textBoxRes.Text);
            }

            switch (calcOperator)
            {
                case "sqrt":
                    if (!(resultValue < 0))
                    {
                        expression = new Sqrt(resultValue);
                        finalValue = expression.Evaluate();
                        textBoxRes.Text = finalValue.ToString();
                    }
                    else textBoxRes.Text = "Can't calculate sqrt of a neg num!";
                    break;

                case "neg":
                    expression = new Opposite(resultValue);
                    finalValue = expression.Evaluate();
                    textBoxRes.Text = finalValue.ToString();
                    break;

                case "cos":
                    expression = new Cosinus(resultValue);
                    finalValue = expression.Evaluate();
                    textBoxRes.Text = finalValue.ToString();
                    break;

                case "sin":
                    expression = new Sinus(resultValue);
                    finalValue = expression.Evaluate();
                    textBoxRes.Text = finalValue.ToString();
                    break;

                case "exp":
                    expression = new Exponentation(resultValue);
                    finalValue = expression.Evaluate();
                    textBoxRes.Text = finalValue.ToString();
                    break;

                case "abs":
                    expression = new Abs(resultValue);
                    finalValue = expression.Evaluate();
                    textBoxRes.Text = finalValue.ToString();
                    break;

                case "log":
                    if (resultValue > 0)
                    {
                        expression = new Log(resultValue);
                        finalValue = expression.Evaluate();
                        textBoxRes.Text = finalValue.ToString();
                    }
                    else textBoxRes.Text = "Can't calculate log of a neg num!";
                    break;

                case "+":                    
                    labelCurrentExpr.Text += sndArgument;
                    expression = new Addition(resultValue, sndArgument);
                    finalValue = expression.Evaluate();
                    textBoxRes.Text = finalValue.ToString();                    
                    break;

                case "-":
                    labelCurrentExpr.Text += sndArgument;
                    expression = new Subtraction(resultValue, sndArgument);
                    finalValue = expression.Evaluate();
                    textBoxRes.Text = finalValue.ToString();
                    break;

                case "*":
                    labelCurrentExpr.Text += sndArgument;
                    expression = new Multiplication(resultValue, sndArgument);
                    finalValue = expression.Evaluate();
                    textBoxRes.Text = finalValue.ToString();
                    break;

                case "/":
                    labelCurrentExpr.Text += sndArgument;
                    if (!sndArgument.Equals(0))
                    {
                        expression = new Division(resultValue, sndArgument);
                        finalValue = expression.Evaluate();
                        textBoxRes.Text = finalValue.ToString();
                    }
                    else
                    {
                        textBoxRes.Text = "Can't divide by 0";
                    }
                    break;

                case "^":
                    labelCurrentExpr.Text += sndArgument;
                    expression = new Power(resultValue, sndArgument);
                    finalValue = expression.Evaluate();
                    textBoxRes.Text = finalValue.ToString();
                    break;

                case "%":
                    labelCurrentExpr.Text += sndArgument;
                    expression = new Modulo(resultValue, sndArgument);
                    finalValue = expression.Evaluate();
                    textBoxRes.Text = finalValue.ToString();
                    break;
            }
            resultValue = 0;
            labelCurrentExpr.Text = "";
        }
    }
}
