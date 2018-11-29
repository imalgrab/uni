using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    public class Sinus : UnaryOperation
    {
        public double value;

        public Sinus(double value)
        {
            this.value = value;
        }

        public override double Evaluate()
        {
            return Math.Sin(value);
        }

        public override string Result()
        {
            return $"sin({value})";
        }
    }
}
