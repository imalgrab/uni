using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    public class Cosinus : UnaryOperation
    {
        public double value;

        public Cosinus(double value)
        {
            this.value = value;
        }

        public override double Evaluate()
        {
            return Math.Cos(value);
        }

        public override string Result()
        {
            return $"cos({value}";
        }
    }
}
