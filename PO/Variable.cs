using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    class Variable : Expression
    {
        public string variable;
        public static Dictionary<string, double> varVals = new Dictionary<string, double>();

        public Variable(string variable, double value)
        {
            this.variable = variable;
            Variable.varVals[variable] = value;
        }

        public Variable(string variable)
        {
            this.variable = variable;
        }

        public override double Evaluate()
        {
            return Variable.varVals[variable];
        }

        public override string Result()
        {
            return variable;
        }
    }
}
